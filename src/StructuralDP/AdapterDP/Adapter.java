package StructuralDP.AdapterDP;

/*
Bir Arabamız var diyelim tren rayları üzerinde götüreceğiz. Nasıl yapabiliriz?
Tren raylarında giden bir platform ile gidebilir hale getiriyoruz. Araya aracı lazım. Ara platform
Bir biri ile uyumlu olan 2 objeyi bir birine uyumlu hale getirmedir Adaptor design pattern
id ile sorgu yapmayı email ile sorgu yapmaya dönüştürme
 */
public class Adapter {
    class OldUser {
        int id;
        String userName;
        String name;
        String lastName;

    }

    interface OldUserService { //sanki ayrı package de diye düşüneceğiz. Eski sistemin seris katmanı
        OldUser getUser(int id); //id uzerinden sorgu yapılıyor

    }


    //yeni user
    class User {
        int id;
        String email;
        String userName;
        String name;
        String lastName;
        String loction;
        boolean isActive;
    }


    //yeni sistem Repo  katmanı
    interface UserRepository {
        User getUser(String email); //yeni sisteim email ile çalışıyor
    }


    //yeni sistemin servisi
    interface UserService {
        User getUser(String email);
    }


    //id'yi email'e cevirmem lazım bunun  ,ç,n bir adaptor kullanacagım

    class UserServiceAdaptor implements UserService {

        UserRepository userRepository;
        OldUserService oldUserService;


        @Override
        public User getUser(String email) {
            User user = userRepository.getUser(email);
            OldUser oldUser = oldUserService.getUser(user.id);//eski kullanıcının user name sini ve
            user.userName = oldUser.userName;
            user.lastName = oldUser.lastName;
            return user;
        }
    }

    //main için gerekli method
    public void adapterDemo() {
        UserService userService = new UserServiceAdaptor();
        User user = userService.getUser("xxx@yy.com");
        System.out.println(user);
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.adapterDemo();
    }
}