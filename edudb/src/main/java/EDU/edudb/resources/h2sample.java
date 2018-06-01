package EDU.edudb.resources;

import org.h2.tools.Server;
import org.junit.rules.ExternalResource;

import io.dropwizard.lifecycle.Managed;

public class h2sample extends ExternalResource implements Managed {

    private Server tcpServer = null;
    private Server webConsole = null;

    public h2sample()  {
        // TODO 自動生成されたコンストラクター・スタブ
        super();
    }

    @Override
    public void start() throws Exception {
            try {
                this.before();
            } catch (Throwable e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
                throw new Exception("H2サーバーの起動失敗", e);
            }
        }


    @Override
    public void stop() throws Exception {
        this.after();
    }

    @Override
    protected void before() throws Throwable {
        // tcpでの接続受付とWebコンソール
        if (tcpServer == null) {
            try {
                tcpServer = Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "20020");
                webConsole = Server.createWebServer("-webPort", "20010");
                tcpServer.start();
                webConsole.start();

            } catch (Throwable e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
                throw new Exception("H2サーバーの起動失敗", e);
            }
        }
    }

    @Override
    protected void after() {
        // サーバのシャットダウン
        tcpServer.shutdown();
        webConsole.shutdown();
    }

}
