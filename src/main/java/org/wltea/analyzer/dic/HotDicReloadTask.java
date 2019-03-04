package org.wltea.analyzer.dic;

import org.apache.logging.log4j.Logger;
import org.wltea.analyzer.dao.IkDicDAO;
import org.wltea.analyzer.help.ESPluginLoggerFactory;

import java.util.List;

public class HotDicReloadTask implements Runnable {

    private static final Logger logger = ESPluginLoggerFactory.getLogger(HotDicReloadTask.class.getName());
    @Override
    public void run() {
        while (true) {
            logger.info("[==========]reload hot dict from mysql......");
            Dictionary.getSingleton().reLoadMainDict();
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            IkDicDAO ikDicDAO = new IkDicDAO();
//            List<String> list = ikDicDAO.queryExtWord();
//            System.out.println(list);

        }
    }

//    public static void main(String[] args) {
//        new Thread(new HotDicReloadTask()).start();
//    }
}
