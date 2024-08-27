public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thread " + getName());
    }
}
