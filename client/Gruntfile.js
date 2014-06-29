'use strict';

/**
 * http://ahexamples.blogspot.kr/2014/03/example-of-jasmine-karma-sonar-grunt.html
 */

module.exports = function (grunt) {

    var $srcAllFiles = 'js/src/**/*.js';
    var $testFiles = 'js/test/**/*Test.js';
    var $outputDir = 'build';
    var $junitResults = $outputDir + '/junit-test-results.xml';
    var $jasmineSpecRunner = $outputDir + '/_SpecRunner.html';
    var $coverageOutputDir = $outputDir + '/coverage';

    var $srcRoot = 'js/src/**/';

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        concat: {
            common: {
                src: $srcRoot + 'common/*.js',
                dest: $outputDir + '/common-<%= pkg.version %>.js'
            },
            approval: {
                src: $srcRoot + 'approval/*.js',
                dest: $outputDir + '/approval-<%= pkg.version %>.js'
            },
            memo: {
                src: $srcRoot + 'memo/*.js',
                dest: $outputDir + '/memo-<%= pkg.version %>.js'
            },
            mail: {
                src: $srcRoot + 'mail/*.js',
                dest: $outputDir + '/mail-<%= pkg.version %>.js'
            },
            sns: {
                src: $srcRoot + 'sns/*.js',
                dest: $outputDir + '/sns-<%= pkg.version %>.js'
            },
            schedule: {
                src: $srcRoot + 'schedule/*.js',
                dest: $outputDir + '/schedule-<%= pkg.version %>.js'
            }
        },

        uglify: {
            build: {
                src: $outputDir + '/app.js',
                dest: $outputDir + '/app.min.js'
            }
        },

        // Jasmine test
        jasmine: {
            pivotal: {
                src: $srcAllFiles,
                options: {
                    specs: $testFiles,
                    outfile: $jasmineSpecRunner,
                    keepRunner: 'true'	// keep SpecRunner/outfile file
                }
            }
        },

        // coverage using Karma
        karma: {
            continuous: {
                singleRun: 'true',
                browsers: [ 'PhantomJS' ]
            },

            options: {
                plugins: [
                    'karma-jasmine',
                    'karma-phantomjs-launcher',
                    'karma-junit-reporter',
                    'karma-coverage'
                ],
                frameworks: [ 'jasmine' ],
                files: [ $srcAllFiles, $testFiles ],
                reporters: [ 'junit', 'coverage' ],
                junitReporter: {
                    outputFile: $junitResults
                },
                preprocessors: {
                    // source files must be a literal string
                    'js/src/**/*.js': [ 'coverage' ]
                },
                coverageReporter: {
                    type: 'lcov',
                    dir: $coverageOutputDir
                }
            }
        },

        // export Karma coverage to SonarQube
        karma_sonar: {
            your_target: {
                // properties for SonarQube dashboard
                project: {
                    key: 'net.ahexample:ahexample-jasmine-karma-sonar',
                    name: 'Jasmine with Karma and SonarQube Example',
                    version: '0.0.1'
                }

                // sources property is set at runtime (see below)
            }
        },

        clean: [ $outputDir ]
    });


    /*
     * Task to set karma_sonar's sources property.
     * This is needed because karma (coverage) stores its results in a
     * directory whose name uses the browser's user agent info
     * (name/version and the platform name).
     * The latter may well he different to the OS name and so its needs an
     * OS to platform translator.
     * For example, OS name for Apple Mac OS X is Darwin.
     */
    grunt.registerTask('set-karma-sonar-sources-property', function () {
        var $done = this.async();
        var $phantomjs = require('karma-phantomjs-launcher/node_modules/phantomjs');
        var $spawn = require('child_process').spawn;
        var $phantomUserAgent = $spawn($phantomjs.path,
            // phantomjs script to print user agent string
            [ 'lib/phantomjs-useragent.js' ]
        );

        /*
         * Construct coverage LCOV file path from PhantomJS'
         * user agent string, then use it to set karma_sonar's
         * sources property.
         */
        $phantomUserAgent.stdout.on('data', function (msg) {
            var $useragent = require('karma/node_modules/useragent');
            var $agent = $useragent.parse(msg);
            // An example of dirName is 'PhantomJS 1.9.7 (Mac OS X)'
            var $dirName = $agent.toAgent() + ' (' + $agent.os + ')';
            var $coverageResults = $coverageOutputDir + '/' + $dirName + '/lcov.info';
            var $sonarSources = makeSonarSourceDirs($srcAllFiles, $coverageResults);
            var $karmaSonarConfig = 'karma_sonar';
            var $ksConfig = grunt.config($karmaSonarConfig);

            grunt.log.writeln('coverage LCOV file: ' + $coverageResults);
            $ksConfig['your_target']['sources'] = $sonarSources;
            grunt.config($karmaSonarConfig, $ksConfig);

        });

        $phantomUserAgent.on('close', function (exitCode) {
            $done();
        });


        /*
         * Create sonar source object for each directory of source file pattern.
         */
        function makeSonarSourceDirs($filesPattern, $coverageResults) {
            var $path = require('path');
            var $dirs = [];

            grunt.file.expand(
                {
                    filter: function ($filePath) {
                        $dirs.push({
                            path: $path.dirname($filePath),
                            prefix: '.',	// path prefix in lcov.info
                            coverageReport: $coverageResults,
                            testReport: $junitResults
                        });
                    }
                },
                $filesPattern
            );

            return $dirs;
        }
    });


    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-jasmine');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-karma-sonar');


    grunt.registerTask('test', [ 'jasmine', 'karma:continuous' ]);
    grunt.registerTask('sonar-only', [ 'set-karma-sonar-sources-property', 'karma_sonar' ]);
    grunt.registerTask('sonar', [ 'test', 'sonar-only' ]);
    grunt.registerTask('default', ['concat:main', 'uglify:build']);
};
