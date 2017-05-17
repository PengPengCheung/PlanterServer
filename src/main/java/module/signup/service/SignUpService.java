package module.signup.service;

import com.sun.org.apache.regexp.internal.RE;
import common.Resource;
import dao.logic.SignUpDAO;
import model.DataResponse;
import module.signup.model.SignUpWebRequestViewModel;
import module.signup.model.SignUpWebResponseViewModel;

import java.util.Map;

/**
 * Created by peng on 2017/4/2.
 */
public class SignUpService {

    SignUpDAO dao;

    public SignUpService(){
        dao = new SignUpDAO();
    }


    public DataResponse<SignUpWebResponseViewModel> signUp(Map<String, String> params){

        SignUpWebRequestViewModel requestViewModel = constructRequestViewMdodel(params);

        createUserByRole(requestViewModel.getRole(), requestViewModel);

        return null;

    }

    private void createUserByRole(int role, SignUpWebRequestViewModel model) {
        switch (role){
            case Resource.ROLE.ROLE_TEACHER:{
                dao.teacherSignUp(model);
            }
            break;
            case Resource.ROLE.ROLE_STUDENT:{
                dao.studentSignUp(model);
            }
            break;
        }
    }

    private SignUpWebRequestViewModel constructRequestViewMdodel(Map<String, String> params) {
        SignUpWebRequestViewModel requestViewModel = new SignUpWebRequestViewModel();

        if(params.containsKey(Resource.KEY.KEY_NAME)){
            requestViewModel.setUserName(params.get(Resource.KEY.KEY_NAME));
        }

        if(params.containsKey(Resource.KEY.KEY_PASSWORD)){
            requestViewModel.setUserPassword(params.get(Resource.KEY.KEY_PASSWORD));
        }

        if(params.containsKey(Resource.KEY.KEY_ROLE)){
            int role = Integer.parseInt(params.get(Resource.KEY.KEY_ROLE));
            requestViewModel.setRole(role);
        }

        return requestViewModel;
    }

}
