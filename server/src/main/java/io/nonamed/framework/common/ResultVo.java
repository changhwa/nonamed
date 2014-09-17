package io.nonamed.framework.common;

import lombok.Data;

/**
 * 통신 후 반환 되는 기본 필드에 대해서 정의한 VO
 * 만약 도메인이 리턴되야 하는 경우 해당 VO를 상속하여 구현하면됩니다.
 * 클라이언트 / 서버 분리 테스트 중이므로 일단 작성 후 전체적으로 리팩토링을 하겠습니다
 *
 * @author Changhwa (changhwaoh.co@gmail.com)
 */
@Data
public class ResultVo {

    public String code;
    public String data;
    public String msg;


}
