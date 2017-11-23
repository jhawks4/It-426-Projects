package facade;

import string_manipulation.StringOperations;

public class Operation {

    private String[] subject;

    public Operation(String [] subject){

        this.subject = subject;

    }

    public String[] getSubject() {
        return subject;
    }

    public Operation filter(String find){

        subject = StringOperations.filter(subject, find);
        return this;
    }

    public Operation removeDuplicates(){
        subject = StringOperations.removeDuplicates(subject);
        return this;
    }

    public Operation resize(int newSize){
        subject = StringOperations.resize(subject, newSize);
        return this;
    }


}
