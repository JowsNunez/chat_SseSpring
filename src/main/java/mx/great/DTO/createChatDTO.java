package mx.great.DTO;

import java.util.ArrayList;
import java.util.List;

public class createChatDTO {
    private ArrayList<Integer> usersId;

    public createChatDTO() {
    }

    public ArrayList<Integer> getUsersId() {
        return usersId;
    }

    public void setUsersId(ArrayList<Integer> usersId) {
        this.usersId = usersId;
    }

    public Integer getType(){
        Integer size =this.usersId.size();
        if(size >2){
            return 2;
        }
        return 1;
    }
}
