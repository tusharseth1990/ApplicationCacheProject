# ApplicationCacheProject
#Design LRU Cache or Application Cache
Problem Statement
Application Cache
An Application stores several entities, such as users, roles and organizations, in a
database. During testing, it is found that the performance of the application is not
good. On analysis, it is found that repeated DB access is causing a performance
bottleneck. The solution is to come up with an in memory cache that caches
recently used (evict LRU) entities.
You are required to implement a cache based on this requirement. This cache
framework should be generic enough to operate over all types of entities.
You also need to implement a class, UserManager that uses the cache to improve
performance. UserManager needs to have createUser, modifyUser, deleteUser
and searchUser functionality.
Guidelines:
1. Implement all operations of cache such as put, modify, get and flush.
2. Minimize the time complexities (execution time) for each supported cache
operation.
3. The API for Cache should be well designed.
4. Use Design Patterns as appropriate
5. You can assume a DBStore interface/mock for fetching any data from DB


General Guidelines:
1. Code should be answered using Java only, preferably Java 5.0 or above.
2. Program should not be dependent on third party libraries.
3. Readability, Extensibility and Testability are the major perspectives code
should be presented.
4. Evaluator should be able to understand and test the code without coder’s
intervention.
5. Assumptions, if any, should be practical and near to real world scenarios

**How to import this Project :**

**Method I:**
1. Download Zip from https://github.com/tusharseth1990/ApplicationCacheProject and extract the same into one folder 
2. In eclipse >> File >> Open Project from File System 
3. click Directory to select Import Source Path and select the folder ApplicationCache
4. Next Finish


**Method II:**

1. Go to Eclipse 
2. File >> Import >> Git >> Projects from Git(with smart Import)
3. click Next >> Clone URL >> Add this URL in URI i.e. https://github.com/tusharseth1990/ApplicationCacheProject.git
4. Click Next >> Select main (select All) >> Click Next
5. Select & Browse from Directory till ApplicationCache & select save
6. Click Finish
