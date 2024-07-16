package utils;




import java.util.HashMap;
import java.util.Map;
import utils.GlobalVariable;

public class GlobalVariableHolder {

        private Map<String, Object> sharedVariable;

    private static GlobalVariableHolder instance;

    public static GlobalVariableHolder getInstance()
    {
        if (instance == null)
            instance = new GlobalVariableHolder();
        return instance;
    }

    public GlobalVariableHolder(){
        sharedVariable = new HashMap<>();
    }

        public void setValue(GlobalVariable key, Object value) {
            sharedVariable = new HashMap<>();
            sharedVariable.put(key.toString(), value);
        }

        public Object getValue(GlobalVariable key){
            return sharedVariable.get(key.toString());
        }

        public Boolean isContains(GlobalVariable key){
            return sharedVariable.containsKey(key.toString());
        }

}
