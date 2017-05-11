package sk.host.arabasso;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by arabasso on 01/10/2016.
 *
 */
public class ApplicationTests {
    @Test
    public void test(){
        assertThat(true, is(equalTo(true)));
    }
}
