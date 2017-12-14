import GUI.GUI;

public class Main implements Runnable
{
    GUI gui = new GUI();


    public static void main (String[] args)
    {
        /**
         * Start a new thread to run
         * within the Main class
         */
        new Thread(new Main() ).start();



    }//end of main

    @Override
    public void run()
    {

    }//end of run

}//end of Main
