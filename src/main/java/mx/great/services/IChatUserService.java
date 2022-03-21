package mx.great.services;

import mx.great.models.Chatuser;

import java.util.ArrayList;
import java.util.List;

public interface IChatUserService {

    boolean create(ArrayList<Integer> usersId, Integer type);
}
