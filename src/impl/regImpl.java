package impl;

import impl.reg;
import impl.select;

public class regImpl {
	reg reg1 = new reg();
	select select1 = new select();
	
	//У��ҵ��,select  
    public int findByUserName(String userName) {  

    	int count = select1.selectByName(userName);
        return count;  
    }  
      
    //ע��ҵ��insert  
    public int register(String userName, String passWord) throws Exception {  
        int count = reg1.register(userName,passWord);
        return count;  
    }  
}
