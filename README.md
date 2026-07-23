# Simple Frontend Webapp (Java + Maven)

Pure Java based frontend web application — JSP (view) + Servlet (backend logic), koi JavaScript framework nahi. Maven se **WAR** file banti hai jo directly Tomcat par deploy ho sakti hai.

## Project Structure
```
simple-frontend-webapp/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/mycompany/webapp/WelcomeServlet.java
│   │   └── webapp/
│   │       ├── index.jsp
│   │       ├── css/style.css
│   │       └── WEB-INF/web.xml
│   └── test/
│       └── java/com/mycompany/webapp/WelcomeServletTest.java
└── README.md
```

## Local Build (apni machine par test karne ke liye)
```bash
mvn clean package
```
Successful build ke baad WAR file yahan milegi:
```
target/simple-frontend-webapp.war
```

## GitHub Par Push Karna

```bash
cd simple-frontend-webapp
git init
git add .
git commit -m "Initial commit - simple frontend webapp"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```

## Jenkins Freestyle Job Setup

1. **New Item** → Freestyle project
2. **Source Code Management** → Git
   - Repository URL: `https://github.com/<your-username>/<your-repo-name>.git`
   - Credentials add karo agar private repo hai
   - Branch: `*/main`
3. **Build Steps** → Invoke top-level Maven targets
   - Goals: `clean package`
4. **Post-build Actions** → Deploy war/ear to a container
   - WAR file: `**/*.war`
   - Container: Tomcat (jo version ho)
   - Credentials: Tomcat manager credentials
   - Tomcat URL: `http://<tomcat-server-ip>:8080`

## SonarQube Analysis Ke Saath (Optional)

Agar isi pipeline me SonarQube bhi chalana hai, "Invoke top-level Maven targets" ke goals me ye add karo:
```
clean package sonar:sonar -Dsonar.projectKey=simple-frontend-webapp -Dsonar.host.url=http://<sonar-server-ip>:9000 -Dsonar.login=$SONAR_AUTH_TOKEN
```

## Deploy Hone Ke Baad Test Karna

Browser me open karo:
```
http://<tomcat-server-ip>:8080/simple-frontend-webapp/
```

- Home page (`index.jsp`) khulega jisme naam daalne ka form hai
- Submit karne par `WelcomeServlet` trigger hoga aur greeting + server time dikhayega

## Note

- `<packaging>war</packaging>` hi is project ko "web application" banata hai — isi wajah se Tomcat deploy step WAR file dhoond payega (`pom.xml` me ye tag zaroor check karna, aapke pichle project me yahi missing tha)
- Servlet API dependency ka scope `provided` hai kyunki Tomcat runtime par khud ye classes provide karta hai — isko WAR ke andar bundle karne ki zarurat nahi
