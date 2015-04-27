package edu.iis.mto.multithread;

import edu.iis.mto.multithread.RepeatRule.Repeat;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat( times = 1000 )
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock( PatriotBattery.class );
        BetterRadar radar = new BetterRadar( batteryMock );
        radar.setExecutor( new MyExecutor() );
        radar.notice( new Scud() );
        verify( batteryMock ).launchPatriot();
    }

}
