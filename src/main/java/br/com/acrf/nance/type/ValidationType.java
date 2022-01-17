package br.com.acrf.nance.type;

public enum ValidationType {
    ANNONYMOUS ("Online");

    String value;

    ValidationType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
