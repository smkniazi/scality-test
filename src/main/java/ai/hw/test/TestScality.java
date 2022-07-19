package ai.hw.test;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestScality {

  String ENDPOINT = "https://s3.isv.scality.com";  // RING
  BasicAWSCredentials CREDENTIALS = new BasicAWSCredentials(
    "XXXXXXXXXXXXXXXXXXXX",
    "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");

//  final String ENDPOINT = "https://artesca.isv.scality.com";  // ARTESCA
//  BasicAWSCredentials CREDENTIALS = new BasicAWSCredentials(
//    "XXXXXXXXXXXXXXXXXXXX",
//    "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");

  final String SIGNINGREGION = "";
  final String BUCKET = "hw-ab-bucket";
  final AmazonS3 s3;

  public static void main(String[] argv) throws IOException {
    TestScality app = new TestScality();
    app.checkBucket();
    app.testUpload();
  }

  public TestScality() {
    s3 = connect();
  }

  private void testUpload() throws IOException {

    String object1Key = "some-key-without-metadata";
    String object2Key = "some-key-with-metadata";
    Path tempFile = Files.createTempFile("scality-test", ".dat");


    // Request1: Upload object without metadata
    PutObjectRequest req1 = new PutObjectRequest(BUCKET, object1Key, tempFile.toFile());


    // Request2: Upload object with some metadata
    HashMap<String, String> metadataMap = new HashMap<>();
    metadataMap.put("GEN_STAMP", Long.toString(0));
    metadataMap.put("BLOCK_SIZE", Long.toString(0));
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setUserMetadata(metadataMap);
    PutObjectRequest req2 = new PutObjectRequest(BUCKET, object2Key, tempFile.toFile());
    req2.setMetadata(objectMetadata);

    uploadObject(req1);
    uploadObject(req2);
  }

  private void uploadObject(PutObjectRequest req) {
    try {
      s3.putObject(req);
      System.out.println("PASS:  Put " + (req.getMetadata() == null ? " without " : " with ") + "metadata");
    } catch (Exception e) {
      System.out.println("FAIL:  Put " + (req.getMetadata() == null ? " without " : " with ") + "metadata");
      e.printStackTrace();
      //throw e;
    }
  }

  private void checkBucket() {
    try {
      if (!s3.doesBucketExistV2(BUCKET)) {
        s3.createBucket(BUCKET);
        System.out.println("Created test bucket " + BUCKET);
      } else {
        System.out.println("Test bucket " + BUCKET + " already exists");
      }

      List<Bucket> buckets = s3.listBuckets();
      System.out.println("Existing bucket are: " + Arrays.toString(buckets.toArray()));

    } catch (Exception e) {
      System.out.println("FAILED to create bucket. Exception: " + e);
      e.printStackTrace();
      throw e;
    }
  }

  private AmazonS3 connect() {
    AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard()
      .withClientConfiguration(new ClientConfiguration()).withCredentials(new
       AWSStaticCredentialsProvider(CREDENTIALS));

    AwsClientBuilder.EndpointConfiguration epc =
      new AwsClientBuilder.EndpointConfiguration(ENDPOINT, SIGNINGREGION);
    builder.withEndpointConfiguration(epc);
    builder.setPathStyleAccessEnabled(true);
    return builder.build();
  }
}
