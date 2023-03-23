package network;

import model.responseModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends JFrame {
        private JPanel panel1;
        private JButton submit;
        private JButton Close;
        private JTextField massage;
        private JTextField status;
        private JTextField comment;

    public MainActivity() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainActivity Koneksisaya = new MainActivity();
                URL myAddres = Koneksisaya.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
                String response = Koneksisaya.getresponseFromHttpUrl(myAddres);
                System.out.println(response);

                JSONArray responJSON = new JSONArray(response);
                ArrayList<responseModel> responmodels = new ArrayList<>();
                int i;
                for (i = 0; i < responJSON.length(); i++) ;
                responseModel resmodel = new responseModel();
                JSONObject myJSONobject = responJSON.getJSONObject(i);
                resmodel.setMsg(myJSONobject.getString("message"));
                resmodel.setStatus(myJSONobject.getString("Status"));
                resmodel.setComments(myJSONobject.getString("Status"));
                responmodels.add(resmodel);
                System.out.println("respone are:");

                for (int index = 0; index < responseModel.size(); index++) {
                    massage.setText(responseModel.get(index).getMsg());
                    status.setText(responseModel.get(index).getstatus());
                    comment.setText(responseModel.get(index).getcomment());
                }
            }
        });
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massage.setText("");
                status.setText("");
                comment.setText("");
            }
        });
    }
    private URL buildURL (String s){
        return buildURL("String s");
    }
        private String getresponseFromHttpUrl (URL myAddres){
        return getresponseFromHttpUrl(myAddres);
    }
        private static class Panel {
            private Container Panel1;
            public static void main(String[] args) {
                JFrame frame = new JFrame("panel1");
                frame.setContentPane(new Panel().Panel1);
                //frame.setUndecorated(true);
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        }
    }