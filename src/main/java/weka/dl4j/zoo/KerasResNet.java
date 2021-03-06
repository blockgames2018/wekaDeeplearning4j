package weka.dl4j.zoo;

import org.deeplearning4j.nn.graph.ComputationGraph;
import weka.core.OptionMetadata;
import weka.dl4j.PretrainedType;
import weka.dl4j.zoo.keras.DenseNet;
import weka.dl4j.zoo.keras.ResNet;

public class KerasResNet extends AbstractZooModel {

    private static final long serialVersionUID = 5525252856492208127L;

    private ResNet.VARIATION variation = ResNet.VARIATION.RESNET50;

    public KerasResNet() {
        setVariation(ResNet.VARIATION.RESNET50);
        setPretrainedType(PretrainedType.IMAGENET);
        setNumFExtractOutputs(2048);
        setFeatureExtractionLayer("avg_pool");
        setOutputLayer("probs");
    }

    @OptionMetadata(
            description = "The model variation to use.",
            displayName = "Model Variation",
            commandLineParamName = "variation",
            commandLineParamSynopsis = "-variation <String>"
    )
    public ResNet.VARIATION getVariation() {
        return variation;
    }

    public void setVariation(ResNet.VARIATION var) {
        variation = var;
    }

    @Override
    public ComputationGraph init(int numLabels, long seed, int[] shape, boolean filterMode) {
        ResNet resNet = new ResNet();
        resNet.setVariation(variation);

        return attemptToLoadWeights(resNet, null, seed, numLabels, filterMode);
    }

    @Override
    public int[][] getShape() {
        int[][] shape = new int[1][];
        shape[0] = ResNet.inputShape;
        return shape;
    }
}
