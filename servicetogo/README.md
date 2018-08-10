**How to start the application for development**

The configuration has been done so that we can run spring boot and angular as seperate server during testing
* Run the bootstrap app in STS, its configured to allow connections from localhost:4200 in CORS config
* For web use VS Code, Open folder `servicetogo\src\web` and type `npm start`

**Frequently used commands**
* To create new component, in VS code terminal

    ng g c new-component --module app --spec false
    ng g c folder/new-component --module app --spec false
    
* To create production build, in VS code terminal

    ng build -prod –output-path ..\main\resources\static

**Note:**

[Learn more about md file: https://guides.github.com/features/mastering-markdown/](https://guides.github.com/features/mastering-markdown/)