# Step-by-step Dev Guide

## Github Setup

1. Create a github account
2. Let it be added to "wsrelay-dev" team
3. Check if you can see the upstream repository https://github.com/Goparatool/application-library-api-support.git on your browser
4. Fork the repository to your own github account. You will be developing under your forked repository.
5. Clone your forked repository, and set the upstream
````git remote add upstream https://github.com/Goparatool/application-library-api-support.git````


## Maven Setup
1. create ~/.m2/setting.xml as  (on windows, "~" = "C:\Users\YourName" or "C:\Documents and Settings\YourName")

````
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 
      http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>goparatool-release-repo</id>
            <username>AKIAJTG7PV54S4IX3BRQ</username>
            <password>jw7DHAhgmy4YI6Q4LLZpYv/VK0vY4Mz2GHAZBekP</password>
        </server>
    </servers>
</settings>
````

2. Go to "wsrelay-impl" under your repository dir. 

3. Do ````mvn package -DskipTests````.  It should work.

## Develop

### First of all, sync your fork with the upstream

````
git fetch upstream
git checkout master
git merge upstream/master
git push -u origin master
````

### Develop a web service relay

#### Know the big picture

![Sequence Diagram](doc/wsr-seq-diagram.png)

What you are doing is an adapter library which will be integrated to the backend. You will,

1. Convert the 3rd-party's request/response's data structure into our adapter restful webservice's data structure (i.e. input metadata and output medadata)
2. Convert the request from our client to one for the 3rd party.
3. Convert the response from the 3rd party to one for our client. 

#### The classes you are going to make

1. A new or existing 3rd party client to directly talk to the 3rd party, such as [GdClient](src/main/java/com/paratool/applib/api/util/thirdpartyhelp/glassdoor/GdClient.java) if appKey/appSecret is required, or [WikiClient](src/main/java/com/paratool/applib/api/util/thirdpartyhelp/wikipedia/WikiClient.java) if appKey/appSecret is not needed.  Your client must implement the interface ````ThirdPartyClientWrapper````.

2. A subclass of ````WsrProxy```` which shows the meta and does the conversion. You can refer to its sub classes as a sample.

3. You need to register the new proxy class to ````WsrProxyDepotImpl```` . 

4. A test case of your 3rd party client such as ````GdClientITCase```` .  

5. A test case of your proxy such as ````WsrGdEmployerSearchProxyITCase```` .  

#### Dev Constraints
1. You should never change an existing proxy's appName. 
2. The data structure of input/output made for client side should be "flat" (every field should not be composite), otherwise it would be difficult for client to render in Excel or on web. Here is an example:    
  *  Wikipedia's original response object has a composite property "featuredReview", which in return have several fields such as "jobTitle", "pros" and "cons"
  *  The backend's output for client should not contain  the composite property "featuredReview", instead it has 3 atomic fields "featuredReviewJobTitle","featuredReviewPros","featuredReviewCons"
3.You are supposed to make changes only under directory "wsrelay-impl". Pull requests changing other directories will be rejected.

### Verify your code
1. Run your test cases. There is not an automatic way of verifying everything, so you need to check the results by reading the console output manually.
2. Do a global running of all test cases
````
mvn verify
````

## Submit for reviewing
1. Submit the code change via github pull request from your repository to the upstream repository.
2. Along with the pull request, please state information including: 
 * Console output generated your test cases. Here is a sample: 
````
	//WsrGdEmployerSearchProxyITCase
	@Test
	public void testMeta() {
		// please submit the json for review
		System.out.println(ProxyTestUtils.toJson(proxy));
	}

	@Test
	public void testInvoke() throws WsrProxyException {
		...
		WsrPage page = proxy.invoke(thisSystemParams, null);
		// please print the result page, verify it manually and also submit it
		// for review
		System.out.println(ProxyTestUtils.toJson(page));

	}
```` 
  * Other information you think important.