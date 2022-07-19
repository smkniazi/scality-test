
README
------


Running the test app
--------------------

````
git clone https://github.com/smkniazi/scality-test
cd scality-test

# Set the end point and credentials in the  Line 22 - 30
vim src/main/java/ai/hw/test/TestScality.java

mvn clean install
java -jar target/scality-test-1.0-jar-with-dependencies.jar
````


RING
----

````
FAILED to create bucket. Exception: com.amazonaws.services.s3.model.AmazonS3Exception: value of the location you are attempting to set - isv - is not listed in the locationConstraint config (Service: Amazon S3; Status Code: 400; Error Code: InvalidLocationConstraint; Request ID: 053b67e2e24a85f30390; S3 Extended Request ID: null; Proxy: null), S3 Extended Request ID: null
com.amazonaws.services.s3.model.AmazonS3Exception: value of the location you are attempting to set - isv - is not listed in the locationConstraint config (Service: Amazon S3; Status Code: 400; Error Code: InvalidLocationConstraint; Request ID: 053b67e2e24a85f30390; S3 Extended Request ID: null; Proxy: null), S3 Extended Request ID: null
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleErrorResponse(AmazonHttpClient.java:1862)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleServiceErrorResponse(AmazonHttpClient.java:1415)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeOneRequest(AmazonHttpClient.java:1384)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeHelper(AmazonHttpClient.java:1154)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.doExecute(AmazonHttpClient.java:811)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeWithTimer(AmazonHttpClient.java:779)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.execute(AmazonHttpClient.java:753)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.access$500(AmazonHttpClient.java:713)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutionBuilderImpl.execute(AmazonHttpClient.java:695)
	at com.amazonaws.http.AmazonHttpClient.execute(AmazonHttpClient.java:559)
	at com.amazonaws.http.AmazonHttpClient.execute(AmazonHttpClient.java:539)
	at com.amazonaws.services.s3.AmazonS3Client.invoke(AmazonS3Client.java:5438)
	at com.amazonaws.services.s3.AmazonS3Client.invoke(AmazonS3Client.java:5385)
	at com.amazonaws.services.s3.AmazonS3Client.createBucket(AmazonS3Client.java:1127)
	at com.amazonaws.services.s3.AmazonS3Client.createBucket(AmazonS3Client.java:1059)
	at ai.hw.test.TestScality.checkBucket(TestScality.java:84)
	at ai.hw.test.TestScality.main(TestScality.java:38)
````

ARTESCA
----

````
Test bucket hw-ab-bucket already exists
Existing bucket are: [S3Bucket [name=hw-ab-bucket, creationDate=Tue Jul 19 10:08:26 CEST 2022, owner=S3Owner [name=hopsworks,id=09652f1b977cadf2da3e55056f2b56fad4a942f1bdbded64ce06a56be99ea151]]]
PASS:  Put  without metadata
FAIL:  Put  with metadata
com.amazonaws.services.s3.model.AmazonS3Exception: The request signature we calculated does not match the signature you provided. (Service: Amazon S3; Status Code: 403; Error Code: SignatureDoesNotMatch; Request ID: cb13d751d74cb60e92c4; S3 Extended Request ID: null; Proxy: null), S3 Extended Request ID: null
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleErrorResponse(AmazonHttpClient.java:1862)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleServiceErrorResponse(AmazonHttpClient.java:1415)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeOneRequest(AmazonHttpClient.java:1384)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeHelper(AmazonHttpClient.java:1154)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.doExecute(AmazonHttpClient.java:811)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.executeWithTimer(AmazonHttpClient.java:779)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.execute(AmazonHttpClient.java:753)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutor.access$500(AmazonHttpClient.java:713)
	at com.amazonaws.http.AmazonHttpClient$RequestExecutionBuilderImpl.execute(AmazonHttpClient.java:695)
	at com.amazonaws.http.AmazonHttpClient.execute(AmazonHttpClient.java:559)
	at com.amazonaws.http.AmazonHttpClient.execute(AmazonHttpClient.java:539)
	at com.amazonaws.services.s3.AmazonS3Client.invoke(AmazonS3Client.java:5438)
	at com.amazonaws.services.s3.AmazonS3Client.invoke(AmazonS3Client.java:5385)
	at com.amazonaws.services.s3.AmazonS3Client.access$300(AmazonS3Client.java:421)
	at com.amazonaws.services.s3.AmazonS3Client$PutObjectStrategy.invokeServiceCall(AmazonS3Client.java:6509)
	at com.amazonaws.services.s3.AmazonS3Client.uploadObject(AmazonS3Client.java:1857)
	at com.amazonaws.services.s3.AmazonS3Client.putObject(AmazonS3Client.java:1817)
	at ai.hw.test.TestScality.uploadObject(TestScality.java:72)
	at ai.hw.test.TestScality.testUpload(TestScality.java:67)
	at ai.hw.test.TestScality.main(TestScality.java:39)
````
