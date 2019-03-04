package org.wltea.analyzer.dic;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.SpecialPermission;
import org.wltea.analyzer.dao.IkDicDAO;
import org.wltea.analyzer.help.ESPluginLoggerFactory;

import java.security.AccessController;
import java.security.BasicPermission;
import java.security.PrivilegedAction;
import java.util.List;

public class HotDicReloadTask implements Runnable {

    private static final Logger logger = ESPluginLoggerFactory.getLogger(HotDicReloadTask.class.getName());
    @Override
    public void run() {
        while (true) {
            logger.info("[==========]reload hot dict from mysql......");

           Dictionary.getSingleton().reLoadMainDict();
//                IkDicDAO ikDicDAO = new IkDicDAO();
//                List<String> list = ikDicDAO.queryExtWord();
//                System.out.println(list);
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new HotDicReloadTask()).start();
    }
}
