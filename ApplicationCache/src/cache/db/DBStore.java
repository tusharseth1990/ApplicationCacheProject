package cache.db;

import cache.model.User;

public interface DBStore {

void addToDB(User user);
void removeFromDB(User user);
void printData();
User isUserExist(int id);
}
