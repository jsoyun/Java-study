package GodOfJava.src.main.java.d.generic;

import java.io.Serializable;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
//        sample.checkCastingDTO();
        sample.checkGenericDTO();
    }

    private void checkCastingDTO() {
        CastingDTO dto1 = new CastingDTO();
        dto1.setObject(new String());

        CastingDTO dto2 = new CastingDTO();
        dto2.setObject(new StringBuffer());

        CastingDTO dto3 = new CastingDTO();
        dto3.setObject(new StringBuilder());

        String temp1 = (String) dto1.getObject();
        StringBuffer temp2 = (StringBuffer) dto2.getObject();
        StringBuilder temp3 = (StringBuilder) dto3.getObject();
        //dto2 의 인스턴스 변수의 타입이 뭔지 어떻게 알고 형변환을 할까?
        //그렇다면 타입 점검을 해보자!
        Object tempObject = dto2.getObject();
        if (tempObject instanceof  StringBuilder) {
            System.out.println("StringBuilder");
        } else if (tempObject instanceof StringBuffer){
            System.out.println("StringBuffer");
        }
        //꼭 타입 점검을 해야할까? 제네릭을 이용해보자
        //제네릭을 이용해 컴파일할 때 점검되도록 해보자 :제네릭: 명시적으로 타입을 지정할 때 사용하는 것

    }
    public void checkGenericDTO(){
        CastingGenericDTO<String> dto1 = new CastingGenericDTO<String>();
        dto1.setObject(new String());

        CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<>();
        dto2.setObject(new StringBuffer());

        CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<>();
        dto3.setObject(new StringBuilder());
        dto1.setObject("dffd");
        String temp1 = dto1.getObject();
        StringBuffer temp2 =  dto2.getObject();
        StringBuilder temp3 =  dto3.getObject();
        System.out.println("/////////"+temp1);


    }
}
