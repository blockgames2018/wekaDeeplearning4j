# DL4JSqueezeNet

[Back to Model Zoo](../../user-guide/model-zoo.md)

```text
======================================================================================================================================================
VertexName (VertexType)                           nIn,nOut   TotalParams   ParamsShape                    Vertex Inputs
======================================================================================================================================================
input_5 (InputVertex)                             -,-        -             -                              -
conv1 (ConvolutionLayer)                          3,64       1,792         W:{64,3,3,3}, b:{1,64}         [input_5]
relu1 (ActivationLayer)                           -,-        0             -                              [conv1]
pool1 (SubsamplingLayer)                          -,-        0             -                              [relu1]
fire2_squeeze1x1 (ConvolutionLayer)               64,16      1,040         W:{16,64,1,1}, b:{1,16}        [pool1]
fire2_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire2_squeeze1x1]
fire2_expand1x1 (ConvolutionLayer)                16,64      1,088         W:{64,16,1,1}, b:{1,64}        [fire2_relu_squeeze1x1]
fire2_expand3x3 (ConvolutionLayer)                16,64      9,280         W:{64,16,3,3}, b:{1,64}        [fire2_relu_squeeze1x1]
fire2_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire2_expand1x1]
fire2_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire2_expand3x3]
fire2_concat (MergeVertex)                        -,-        -             -                              [fire2_relu_expand1x1, fire2_relu_expand3x3]
fire3_squeeze1x1 (ConvolutionLayer)               128,16     2,064         W:{16,128,1,1}, b:{1,16}       [fire2_concat]
fire3_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire3_squeeze1x1]
fire3_expand1x1 (ConvolutionLayer)                16,64      1,088         W:{64,16,1,1}, b:{1,64}        [fire3_relu_squeeze1x1]
fire3_expand3x3 (ConvolutionLayer)                16,64      9,280         W:{64,16,3,3}, b:{1,64}        [fire3_relu_squeeze1x1]
fire3_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire3_expand1x1]
fire3_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire3_expand3x3]
fire3_concat (MergeVertex)                        -,-        -             -                              [fire3_relu_expand1x1, fire3_relu_expand3x3]
pool3 (SubsamplingLayer)                          -,-        0             -                              [fire3_concat]
fire4_squeeze1x1 (ConvolutionLayer)               128,32     4,128         W:{32,128,1,1}, b:{1,32}       [pool3]
fire4_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire4_squeeze1x1]
fire4_expand1x1 (ConvolutionLayer)                32,128     4,224         W:{128,32,1,1}, b:{1,128}      [fire4_relu_squeeze1x1]
fire4_expand3x3 (ConvolutionLayer)                32,128     36,992        W:{128,32,3,3}, b:{1,128}      [fire4_relu_squeeze1x1]
fire4_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire4_expand1x1]
fire4_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire4_expand3x3]
fire4_concat (MergeVertex)                        -,-        -             -                              [fire4_relu_expand1x1, fire4_relu_expand3x3]
fire5_squeeze1x1 (ConvolutionLayer)               256,32     8,224         W:{32,256,1,1}, b:{1,32}       [fire4_concat]
fire5_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire5_squeeze1x1]
fire5_expand1x1 (ConvolutionLayer)                32,128     4,224         W:{128,32,1,1}, b:{1,128}      [fire5_relu_squeeze1x1]
fire5_expand3x3 (ConvolutionLayer)                32,128     36,992        W:{128,32,3,3}, b:{1,128}      [fire5_relu_squeeze1x1]
fire5_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire5_expand1x1]
fire5_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire5_expand3x3]
fire5_concat (MergeVertex)                        -,-        -             -                              [fire5_relu_expand1x1, fire5_relu_expand3x3]
pool5 (SubsamplingLayer)                          -,-        0             -                              [fire5_concat]
fire6_squeeze1x1 (ConvolutionLayer)               256,48     12,336        W:{48,256,1,1}, b:{1,48}       [pool5]
fire6_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire6_squeeze1x1]
fire6_expand1x1 (ConvolutionLayer)                48,192     9,408         W:{192,48,1,1}, b:{1,192}      [fire6_relu_squeeze1x1]
fire6_expand3x3 (ConvolutionLayer)                48,192     83,136        W:{192,48,3,3}, b:{1,192}      [fire6_relu_squeeze1x1]
fire6_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire6_expand1x1]
fire6_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire6_expand3x3]
fire6_concat (MergeVertex)                        -,-        -             -                              [fire6_relu_expand1x1, fire6_relu_expand3x3]
fire7_squeeze1x1 (ConvolutionLayer)               384,48     18,480        W:{48,384,1,1}, b:{1,48}       [fire6_concat]
fire7_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire7_squeeze1x1]
fire7_expand1x1 (ConvolutionLayer)                48,192     9,408         W:{192,48,1,1}, b:{1,192}      [fire7_relu_squeeze1x1]
fire7_expand3x3 (ConvolutionLayer)                48,192     83,136        W:{192,48,3,3}, b:{1,192}      [fire7_relu_squeeze1x1]
fire7_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire7_expand1x1]
fire7_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire7_expand3x3]
fire7_concat (MergeVertex)                        -,-        -             -                              [fire7_relu_expand1x1, fire7_relu_expand3x3]
fire8_squeeze1x1 (ConvolutionLayer)               384,64     24,640        W:{64,384,1,1}, b:{1,64}       [fire7_concat]
fire8_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire8_squeeze1x1]
fire8_expand1x1 (ConvolutionLayer)                64,256     16,640        W:{256,64,1,1}, b:{1,256}      [fire8_relu_squeeze1x1]
fire8_expand3x3 (ConvolutionLayer)                64,256     147,712       W:{256,64,3,3}, b:{1,256}      [fire8_relu_squeeze1x1]
fire8_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire8_expand1x1]
fire8_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire8_expand3x3]
fire8_concat (MergeVertex)                        -,-        -             -                              [fire8_relu_expand1x1, fire8_relu_expand3x3]
fire9_squeeze1x1 (ConvolutionLayer)               512,64     32,832        W:{64,512,1,1}, b:{1,64}       [fire8_concat]
fire9_relu_squeeze1x1 (ActivationLayer)           -,-        0             -                              [fire9_squeeze1x1]
fire9_expand1x1 (ConvolutionLayer)                64,256     16,640        W:{256,64,1,1}, b:{1,256}      [fire9_relu_squeeze1x1]
fire9_expand3x3 (ConvolutionLayer)                64,256     147,712       W:{256,64,3,3}, b:{1,256}      [fire9_relu_squeeze1x1]
fire9_relu_expand1x1 (ActivationLayer)            -,-        0             -                              [fire9_expand1x1]
fire9_relu_expand3x3 (ActivationLayer)            -,-        0             -                              [fire9_expand3x3]
fire9_concat (MergeVertex)                        -,-        -             -                              [fire9_relu_expand1x1, fire9_relu_expand3x3]
drop9 (DropoutLayer)                              -,-        0             -                              [fire9_concat]
conv10 (ConvolutionLayer)                         512,1000   513,000       W:{1000,512,1,1}, b:{1,1000}   [drop9]
relu10 (ActivationLayer)                          -,-        0             -                              [conv10]
global_average_pooling2d_5 (GlobalPoolingLayer)   -,-        0             -                              [relu10]
loss (ActivationLayer)                            -,-        0             -                              [global_average_pooling2d_5]
------------------------------------------------------------------------------------------------------------------------------------------------------
            Total Parameters:  1,235,496
        Trainable Parameters:  1,235,496
           Frozen Parameters:  0
======================================================================================================================================================
```