package Curriculum2;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by T.Ishikawa on 2017/03/21.
 */
public class Employee_Management extends JFrame{
    private JComponent component;
    private Image[] images;
    private Image[] icons;
    private int padding = 60;
    private int space = 120;
    private int interval = 40;
    private final EmployeeList employeeList = new EmployeeList();
    Employee_Management(){
        setDefaultCloseOperation(3);
        setSize(new Dimension(500,300));
        setResizable(false);
        setLocationRelativeTo(null);
        component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor(Color.white);
                g2d.fillRect(0,0,600,400);
                g2d.setColor(Color.YELLOW.darker());
                g2d.setFont((g.getFont().deriveFont( Font.ITALIC , 100f)));
                g2d.drawString("F",padding + 4,80);
                g2d.setColor(Color.YELLOW);
                g2d.drawString("F",padding,80);
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 50f)));
                g2d.drawString(" orce",padding + interval,80);
                g2d.scale(1.0,-1.0);
                g2d.setColor(Color.YELLOW.darker());
                g2d.setFont((g.getFont().deriveFont( Font.ITALIC , 100f)));
                g2d.drawString("F",padding + 4,-85);
                g2d.setColor(Color.YELLOW);
                g2d.drawString("F",padding,-85);
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 50f)));
                g2d.drawString(" orce",padding + interval,-85);
                g2d.scale(1.0,-1.0);

                g2d.setColor(Color.RED.darker());
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 100f)));
                g2d.drawString("S",padding + interval + space + 4,154);
                g2d.setColor(Color.RED);
                g2d.drawString("S",padding + interval + space,150);
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 50f)));
                g2d.drawString("oftware",padding + interval*2 + 30 + space,150);
                g2d.scale(1.0,-1.0);
                g2d.setColor(Color.RED.darker());
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 100f)));
                g2d.drawString("S",padding + interval + space + 4,-159);
                g2d.setColor(Color.RED);
                g2d.drawString("S",padding + interval + space,-155);
                g2d.setFont((g.getFont().deriveFont(Font.ITALIC , 50f)));
                g2d.drawString("oftware",padding + interval*2 + 30 + space,-155                                                                     );
                g2d.scale(1.0,-1.0);
                g2d.setColor(Color.black);
                g2d.drawRect(0,225,496,10);
            }
        };
        add(component);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new Employee_Management());
    }

    private class ProgressBar extends SwingWorker{
        @Override
        protected void process(List chunks) {

        }

        @Override
        protected Object doInBackground() throws Exception {
            return null;
        }
    }
    private class IndexPanel extends JFrame {
        IndexPanel(){
            setDefaultCloseOperation(3);
            setResizable(false);
            setSize(new Dimension(1000,600));

        }
    }

    private class Employee_Info{
        private int ID;
        private String First_Name;
        private String Last_Name;
        private String Department_Name;
        private String E_Mail;

        Employee_Info(int id, String first_Name, String last_Name , String department_Name, String e_Mail){
            setID(id);
            setFirst_Name(first_Name);
            setLast_Name(last_Name);
            setDepartment_Name(department_Name);
            setE_Mail(e_Mail);
        }

        @Deprecated public void setID(int id){
                ID = id;
        }

        public int getID(){return ID;}

        public String getLast_Name() {
            return Last_Name;
        }

        @Deprecated public void setLast_Name(String last_Name) {
            Last_Name = last_Name;
        }

        public String getFirst_Name() {
            return First_Name;
        }

        @Deprecated public void setFirst_Name(String first_Name) {
            First_Name = first_Name;
        }

        public String getDepartment_Name() {
            return Department_Name;
        }

        public void setDepartment_Name(String department_Name) {
            Department_Name = department_Name;
        }

        public String getE_Mail() {
            return E_Mail;
        }

        public void setE_Mail(String e_Mail) {
            E_Mail = e_Mail;
        }
    }

    private class EmployeeList {
        private int counter;
        private int length;
        EmployeeList(){
            length = 5;
            list = new Employee_Info[length];
        }
        private Employee_Info[] list;

        public void add(Employee_Info info){
            if(counter == length){
                list = Arrays.copyOf(list,length += 5);
            }
            list[counter] = info;
            counter++;
            return;
        }

        @Deprecated public Employee_Info getInfo(int ID) throws Exception {
            for(Employee_Info info:list){
                if(info.getID() == ID){
                    return info;
                }
            }
            throw new Exception("ID not found!");
        }

        public List getList(){
            return Arrays.asList(list);
        }
    }
}
