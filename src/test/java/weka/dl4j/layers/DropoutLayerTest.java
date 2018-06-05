package weka.dl4j.layers;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.deeplearning4j.nn.conf.layers.BaseLayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import weka.dl4j.NeuralNetConfiguration;
import weka.dl4j.dropout.AbstractDropout;
import weka.dl4j.dropout.AlphaDropout;
import weka.dl4j.dropout.Dropout;
import weka.dl4j.dropout.GaussianDropout;
import weka.dl4j.dropout.GaussianNoise;

/**
 * A dropout layer test.
 *
 * @author Steven Lang
 */
@Slf4j
public class DropoutLayerTest extends AbstractFeedForwardLayerTest<DropoutLayer> {

  @Before
  @Override
  public void initialize() {
    layer = new DropoutLayer();
    log.info("Init called");
  }

  @Test
  public void testDropout() {
    for (AbstractDropout dropout :
        new AbstractDropout[]{
            new AlphaDropout(),
            new Dropout(),
            new GaussianDropout(),
            new GaussianNoise()
        }) {
      layer.setDropout(dropout);

      assertEquals(dropout, layer.getDropout());
    }
  }

}