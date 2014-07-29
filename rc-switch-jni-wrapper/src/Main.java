import com.opitz.jni.NativeRCSwitchAdapter;

public class Main {

    public static void main(String[] args) {

        NativeRCSwitchAdapter adapter = NativeRCSwitchAdapter.getInstance();

        String group = args[0];
        String unit = args[1];

        //adapter.sendBinary("1010101011");

        adapter.switchOn(group, unit);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        adapter.switchOff(group, unit);


    }
}
