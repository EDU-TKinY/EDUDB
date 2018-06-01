package EDU.edudb;

import EDU.edudb.resources.h2sample;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class sampleApplication extends Application<sampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new sampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "piyo";
    }

    @Override
    public void initialize(final Bootstrap<sampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final sampleConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        h2sample h2serverResource = new h2sample();
        environment.lifecycle().manage(h2serverResource);
    }

}
