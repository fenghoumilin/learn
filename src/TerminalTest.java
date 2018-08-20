
public class TerminalTest {

    public static void main(String[] args) {

        String deviceModel = "iPhonessss";

        System.out.println(getDeviceType(deviceModel));
    }


    public static String getDeviceType(String deviceModel) {

        deviceModel = deviceModel.trim();
        //判断是否有 | 来区分ios 和 android
        int index = deviceModel.lastIndexOf("|");
        System.out.println(index);
        if (index > 0) {
            //android
            String sub = deviceModel.substring(index+1);
            if ("phone".equals(sub)) {
                return "phone";
            }else {
                return "pad";
            }

        }else {
            //ios
            if (deviceModel.contains("iPhone") ){
                return "phone";
            }else {
                return "pad";
            }
        }
    }


}
