package gh.funthomas424242.algorithmen.reihenfolge.generics.complextate;

import gh.funthomas424242.algorithmen.reihenfolge.generics.Bool;
import gh.funthomas424242.algorithmen.reihenfolge.generics.True;

public class JobConf<IN extends Bool, H extends Bool, J extends Bool> {

    protected String id;
    protected String name;
    protected String host;
    protected Runnable job;

    public JobConf<True, H, J> setName(final String name) {
        final JobConf<True, H, J> newConf = new JobConf<>();
        newConf.id = id;
        newConf.name = name;
        newConf.host = host;
        newConf.job = job;
        return newConf;
    }

    public JobConf<True, H, J> setId(final String id) {
        final JobConf<True, H, J> newConf = new JobConf<>();
        newConf.id = id;
        newConf.name = name;
        newConf.host = host;
        newConf.job = job;
        return newConf;
    }

    public JobConf<IN, True, J> setHost(final String host) {
        final JobConf<IN, True, J> newConf = new JobConf<>();
        newConf.id = id;
        newConf.name = name;
        newConf.host = host;
        newConf.job = job;
        return newConf;
    }

    public JobConf<IN, H, True> setRunnable(Runnable job) {
        final JobConf<IN, H, True> newConf = new JobConf<>();
        newConf.id = id;
        newConf.name = name;
        newConf.host = host;
        newConf.job = job;
        return newConf;
    }

}
