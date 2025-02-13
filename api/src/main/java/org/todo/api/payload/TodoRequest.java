package org.todo.api.payload;

import lombok.Data;

@Data
public class TodoRequest {
    private String title;
    private boolean isCompleted;

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title){
//        this.title = title;
//    }
//
//    public boolean isCompleted(){
//        return isCompleted();
//    }


}
