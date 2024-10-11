
### pom maven-jar-plugin 配置 
``` xml
 <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
 <addDefaultSpecificationEntries>true</addDefaultSpecificationEntries>
```

### 生成文件
```text
Manifest-Version: 1.0
Created-By: Apache Maven ${maven.version}
Build-Jdk: ${java.version}
Specification-Title: ${project.name}
Specification-Version: ${project.artifact.selectedVersion.majorVersion}.${project.artifact.selectedVersion.minorVersion}
Specification-Vendor: ${project.organization.name}
Implementation-Title: ${project.name}
Implementation-Version: ${project.version}
Implementation-Vendor: ${project.organization.name}
```