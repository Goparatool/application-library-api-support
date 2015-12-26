# Step by step guide

## Upgrade the models(Javabeans) from the newest swagger json using swagger-codegen. (Optional)


````
java -jar -Dmodels  -DsupportingFiles=StringUtil.java modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate   -i https://applib.goparatoolapi.com/uoapi/swagger.json -l java  -o /path/to/this/client/project -c /path/to/your/config/file/pala-cg.json

````

the pala-cg.json looks like 

````
{"apiPackage":"com.paratool.applib.client.api","artifactId":"application-library-client","groupId":"com.paratool","invokerPackage":"com.paratool.applib.client.invoker","library":"jersey2","modelPackage":"com.paratool.applib.client.model"}
````

You can also generate a C# one. 

````
java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate   -i https://applib.goparatoolapi.com/uoapi/swagger.json -l csharp  -o /path/to/yoour/csharp/project
````


## Read the demo code

See  ````com.paratool.applib.client.itcases.PalaDemoITCase````.   You will know how to write a client for these APIs.