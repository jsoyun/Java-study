package GodOfJava.src.main.java.d.generic;

import java.io.Serializable;

//제네릭 타입이름
//E 요소, K키, N 숫자,T 타입 , V 값 S,U,V 두번째 세번째 네번째

public class CastingGenericDTO<T> implements Serializable {
    private T object;
    public void setObject(T obj){
        this.object = obj;
    }
    public T getObject(){
        return object;
    }
}
