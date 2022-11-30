package expo.modules.updates.codesigning

import androidx.test.platform.app.InstrumentationRegistry

/**
 * These are generated using https://github.com/expo/code-signing-certificates/blob/main/scripts/generateCertificatesForTests.ts
 */
enum class TestCertificateType(val certName: String) {
  CHAIN_INTERMEDIATE("chainIntermediate"),
  CHAIN_LEAF("chainLeaf"),
  CHAIN_ROOT("chainRoot"),
  INVALID_SIGNATURE_CHAIN_LEAF("invalidSignatureChainLeaf"),
  NOT_CODE_SIGNING_EXTENDED_USAGE("noCodeSigningExtendedUsage"),
  NO_KEY_USAGE("noKeyUsage"),
  SIGNATURE_INVALID("signatureInvalid"),
  VALID("test"),
  VALIDITY_EXPIRED("validityExpired"),
  CHAIN_NOT_CA_ROOT("chainNotCARoot"),
  CHAIN_NOT_CA_INTERMEDIATE("chainNotCAIntermediate"),
  CHAIN_NOT_CA_LEAF("chainNotCALeaf"),
  CHAIN_PATH_LEN_VIOLATION_ROOT("chainPathLenViolationRoot"),
  CHAIN_PATH_LEN_VIOLATION_INTERMEDIATE("chainPathLenViolationIntermediate"),
  CHAIN_PATH_LEN_VIOLATION_LEAF("chainPathLenViolationLeaf"),
  CHAIN_EXPO_PROJECT_INFORMATION_VIOLATION_ROOT("chainExpoProjectInformationViolationRoot"),
  CHAIN_EXPO_PROJECT_INFORMATION_VIOLATION_INTERMEDIATE("chainExpoProjectInformationViolationIntermediate"),
  CHAIN_EXPO_PROJECT_INFORMATION_VIOLATION_LEAF("chainExpoProjectInformationViolationLeaf"),
}

fun getTestCertificate(testCertificateType: TestCertificateType): String {
  return InstrumentationRegistry.getInstrumentation().context.assets.open("${CertificateFixtures::class.java.canonicalName}/${testCertificateType.certName}.pem").readBytes().decodeToString()
}

object CertificateFixtures {
  const val testClassicManifestBody = "{\"sdkVersion\":\"39.0.0\",\"releaseId\":\"0eef8214-4833-4089-9dff-b4138a14f196\",\"commitTime\":\"2020-11-11T00:17:54.797Z\",\"bundleUrl\":\"https://url.to/bundle.js\"}"

  const val testNewManifestBody = "{\"id\":\"0754dad0-d200-d634-113c-ef1f26106028\",\"createdAt\":\"2021-11-23T00:57:14.437Z\",\"runtimeVersion\":\"1\",\"assets\":[{\"hash\":\"cb65fafb5ed456fc3ed8a726cf4087d37b875184eba96f33f6d99104e6e2266d\",\"key\":\"489ea2f19fa850b65653ab445637a181.jpg\",\"contentType\":\"image/jpeg\",\"url\":\"http://192.168.64.1:3000/api/assets?asset=updates/1/assets/489ea2f19fa850b65653ab445637a181&runtimeVersion=1&platform=android\",\"fileExtension\":\".jpg\"}],\"launchAsset\":{\"hash\":\"323ddd1968ee76d4ddbb16b04fb2c3f1b6d1ab9b637d819699fecd6fa0ffb1a8\",\"key\":\"696a70cf7035664c20ea86f67dae822b.bundle\",\"contentType\":\"application/javascript\",\"url\":\"http://192.168.64.1:3000/api/assets?asset=updates/1/bundles/android-696a70cf7035664c20ea86f67dae822b.js&runtimeVersion=1&platform=android\",\"fileExtension\":\".bundle\"},\"extra\":{\"scopeKey\":\"@test/app\",\"eas\":{\"projectId\":\"285dc9ca-a25d-4f60-93be-36dc312266d7\"}}}"
  const val testNewManifestBodySignature = "sig=\"iMU4xouvBS6f8Ttr2pUX+r5dJ51489SQfhHb4rG6uBhy5RxaY10o+DE3zVRyRH2yVnmp5Fe7bCQD+REZa0hvt/sKAp1aIhjH8Uv50hADwAPfbyDoOc3Kld2zOGTf70W5J6AyO5QczBrC+wB727CZU+mUkxT6rZ/uBwJVPHAF0qmNGnbJBhMRhGqSB1u/CO49Y7zQ1T53SQvcU2VDq2XtGnPDPCe4qYVV/0oLv1hDSzKqVs6IQu8OYfQwj3naGo3FBFj8fZFbcf8M3B2AU4Q5VigFpLi07rvPyCtDyD6BauU9yk5+sI9RPmm2XtCm1YFzYeicC9BN/QPCBQvj5b7ZIA==\""
  const val testNewManifestBodyValidChainLeafSignature = "sig=\"g94qm1faIg7u0CFJHb/dsk/+2GOsL9xidAbdVzwJXMkzZKaR/aoXkrUTVty1k8jJYIASLhqEQb3O4eBM0zCtzQPaquloxcLSGIA7dy2Yevnl2/HYu14Lmq6yCDMp9F47jtZdbJY+pDAg0D7SfoVkKpBwfoeP1ZXUxtbEBxxzpAkKNhAKmZ/A6VjStrxbTE6qaTEDCbQtOFiREAL2vD3fq9K02a3/PGYU7w7AS5TiPzQ+xCvXl6KOn15ZOZngZs/gvOHjDZbBJsMSzeXHUWDQ993aNzgtawFIgNJkVoiz9Z89LRdcCvCMFahpfUWQWIVsGp47scHMGX6s2PN0m/4S+A==\""

  const val testNewManifestBodyIncorrectProjectId = "{\"id\":\"0754dad0-d200-d634-113c-ef1f26106028\",\"createdAt\":\"2021-11-23T00:57:14.437Z\",\"runtimeVersion\":\"1\",\"assets\":[{\"hash\":\"cb65fafb5ed456fc3ed8a726cf4087d37b875184eba96f33f6d99104e6e2266d\",\"key\":\"489ea2f19fa850b65653ab445637a181.jpg\",\"contentType\":\"image/jpeg\",\"url\":\"http://192.168.64.1:3000/api/assets?asset=updates/1/assets/489ea2f19fa850b65653ab445637a181&runtimeVersion=1&platform=android\",\"fileExtension\":\".jpg\"}],\"launchAsset\":{\"hash\":\"323ddd1968ee76d4ddbb16b04fb2c3f1b6d1ab9b637d819699fecd6fa0ffb1a8\",\"key\":\"696a70cf7035664c20ea86f67dae822b.bundle\",\"contentType\":\"application/javascript\",\"url\":\"http://192.168.64.1:3000/api/assets?asset=updates/1/bundles/android-696a70cf7035664c20ea86f67dae822b.js&runtimeVersion=1&platform=android\",\"fileExtension\":\".bundle\"},\"extra\":{\"scopeKey\":\"@test/app\",\"eas\":{\"projectId\":\"485dc9ca-a25d-4f60-93be-36dc312266d8\"}}}"
  const val testNewManifestBodyValidChainLeafSignatureIncorrectProjectId = "sig=\"Pqwt5yNggdCrXB1w+EeEl9ZLITZVdNeR99YRYw6la3P97xU6298eMs5Us3RNthy/DmsC1tEpqr9MZE4xv2b3l8DZTQ45OyH76TRzRKOtB+9t5VC3Zb/osYjkh/pexr7D9AopSbxNCrVLO3Ek/+2iPXhJAkO90oWpD1Axf7ZhfmzgD0t93lpCzNecyIz2/GRRA5us7VYCFJXkAF6MDzExGQmsWr4OvGpqxqYEHhLfrrFrr0aILCHRjiBlT6zhJi8RzpTPzmH3twq5LSVNES9aa5/VOCgrg2ci6rYXFbmLA4weUpzoEL1Hx88ONcchz7LuEg1zz8pJEJ0olzTGKpJFLQ==\""

  const val testMessageNoUpdateAvailable = "{\"messageType\":\"noUpdateAvailable\",\"signingInfo\":{\"projectId\":\"285dc9ca-a25d-4f60-93be-36dc312266d7\",\"scopeKey\":\"@test/app\"}}"
  const val testMessageNoUpdateAvailableSignature = "sig=\"C72JA1Vl+OHMYO0ZU2RtTpu0xlqK98y1iAapVzjMEUGYfLWTy35a0ZS2njgU4WIhObY+UJ/2yLf6CuCMpwmZolC6YjgbAlar+iiR2FzAz9QBmd50iiDvoMpzxxlptpWhNp0Ybf9653ASKBhhynyHeZok8c/3FwyBeLwJRoMyNi+gqut+Id01z0vD+i6n2rL908nc4yEk7sm3Yxq5STl9Ukwl8ywWbBdpMF8pPx72kMZLAwJAXbKYiuL2SucIM3hbOZJnA+IgrgKjxoiPjpJykwCHR8ZHGhmI5FQbQb4HOZUL+D974WmcnxxtPdQSdfkxsL7t+lJ2MbhOt+7GJWBXpg==\""
  const val testMessageNoUpdateAvailableValidChainLeafSignature = "sig=\"a5QTI/TZ3wP3iF4GVKNVadzGsmqym+EqAeRbDJGBH1lqD9co9TBf2rX0tA2xqFabdC0WNQg+4oPF43eHo0THf0sBC9IikpybsJzXHB1a+ui9SVqeb9FSXD8K5zCn5EZeuO50P7SK2/kyKrABKZ3P2PIyFU4lMT3W8FlrtKpEdmJW5lYYzJY+BC3k4K8snzuMYQS9cgiovHU0QLgnK7zkI3jC1OlNMJsT/4wbGBxOi9cFAfv7Xg6OTCFu+dhy476iCt9oAKA1sC6ORx7bNBWWMcsasCzqRnH9xgen9f9Y4pPdOAZNhprNTJf7jGg1n/wV4dU25jTZ9kYOslRUzthuHQ==\""

  const val testMessageNoUpdateAvailableIncorrectProjectId = "{\"messageType\":\"noUpdateAvailable\",\"signingInfo\":{\"projectId\":\"485dc9ca-a25d-4f60-93be-36dc312266d8\",\"scopeKey\":\"@test/app\"}}"
  const val testMessageNoUpdateAvailableValidChainLeafSignatureIncorrectProjectId = "sig=\"j5dp/H02xzHMdDt4KF6FV4EnpOiZHIrqXHwFEIxXoeq28kaRNRCyvSf5jjZ8zZZtMqoelNrgVtr21XOO6mFKQMdYwg9PB2Dsphj6L+oN4P2K+tDs5NXOvUK3c13fQjLckKYoK8uor+3L9Mea4wC1J5cUYmvz9FpQvsUAtrVDY4ZqtsPw4SR5FgEW5GIlUKpUFN1Qgrq1uLhKMwIX4YXlp3IIASF+ZtjgTvITztZqwkFv45XWuA2pahsJ8vWnC0TACx+sEtoALmIBPAyXmnfeCyyBSowxFZS8GAs9juNB6S9A8s3e4agA0HRXvyW42CkuR5vOzzAYAZ6GCxFhdOOlfA==\""
}
