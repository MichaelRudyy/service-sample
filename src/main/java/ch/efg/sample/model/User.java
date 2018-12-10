package ch.efg.sample.model;

import ch.efg.sample.api.IUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements IUser {
    private String id;
    private String name;
    private String groupId;

    //    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getGroupId() {
//        return groupId;
//    }
//}
}