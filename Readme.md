#Cucumber Framework for Demo-blaze Application 
#Framework Format
1.configuration properties:
to evade hard coding , we centralize the 
test data to keep a smooth flow of the execution of our codes
* centralize location , allows cross browsing 
* uses key and value format
* you can change the browser type and test with different browsers over here
2. create resources directory same level with java directory 
the purpose is to hold our scenarios for the project
* we need to write feature and I can push the code otherwise I can see the directory in github
3. create java packages starting with runners
 * runners(run scenarios with chuckrunner)
 * pages(pom)
 * utilities()
 * we connect the step definitions with feature files using glue keyword
4. we create a base page because we need to write some code to be shared on the GitHub otherwise we can't share out project on GitHub
5. file==> settings==> version control==> github==>make sure your account name is in your version control account locations
6. we need to have git.exefile
7. we share the project on github and everything turn into red cause they are not added to the stagin g env yet
8. add git.ignore click project file and add file
9. in your real company there will be some other files you might need to ignore