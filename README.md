
# Android Studio Pokemon App

## App의 구조
* 네 개의 tab으로 구성하였고 각각 연락처, 갤러리, 단어장과 게임배틀이다. 각각을 Activity가 아닌 Fragment로 구성하였고, onCreateView 함수를 이용하여 각각의 content를 화면에 배치하였다.  
##  1. Tab1 : 연락처 앱
* json file을 만들어 json parsing 함수를 이용하여, 이름과 전화번호 정보를 key, value pair로 넣어주고, RecyclerView에 정보들을 띄웠다. 
* Manifest.xml에서 해당 permission을 추가하니 recyclerview 클릭 후 바로 해당 번호의 전화 다이얼로 넘어갈 수 있었다.
```c
<uses-permission android:name="android.permission.DIAL_PHONE" />
```
![연락처](https://user-images.githubusercontent.com/90722804/177328746-4e88d2c4-4746-469d-b87d-1a8b47a82eca.jpg)
![KakaoTalk_20220705_213027621_13](https://user-images.githubusercontent.com/90722804/177328764-e7710ce2-baf8-4464-9d04-a2b11f6a8f31.jpg)


## 2. Tab2 : 갤러리 앱
* 포켓몬 캐릭터 이미지 20개를 띄웠고, Recyclerview, StaggeredGridLayoutManager를 통해 3개의 이미지가 한 줄에 나오게 하였다.
* 하나의 이미지(view cell)을 클릭하면 해당 캐릭터 이미지를 크게 볼 수 있는 창이 나온다. 이 창에서 Exit button을 통해 이전 Activity로 돌아갈 수 있는 창을 만들었다.
* 이 view의 재생 버튼을 클릭하면, 해당 캐릭터가 나오는 포켓몬 영상을 볼 수 있다.
* Intent와 startActivity를 통해 activity 끼리 이동할 수 있도록 했다.
![KakaoTalk_![KakaoTalk_20220705_213027621_08](https://user-images.githubusercontent.com/90722804/177328987-2342dd95-d995-49f7-9a04-cd91355756d1.jpg)
20220705_213027621_07](https://user-images.githubusercontent.com/90722804/177328956-618e9fc7-0d75-42e6-af32-1f319c30da46.jpg)
![KakaoTalk_20220705_213027621_11](https://user-images.githubusercontent.com/90722804/177329001-667d30c3-1f6a-40b0-9fa1-49e3cd243b4e.jpg)

## 3. Tab3 : 영어단어장 앱
* 영어 단어장을 Recyclerview의 StaggeredGridLayoutManager를 이용하여 grid로 20개의 단어를 띄운 뒤, 그림이나 단어를 클릭하면, Toast로 그 단어의 한국말 뜻을 알려주는 탭이다.
* Butt![KakaoTalk_20220705_213027621_10](https://user-images.githubusercontent.com/90722804/177329039-db25c4c9-8e77-452b-b8f2-6262ef5fe1e7.jpg)
on 안에 text와 이미지를 동시 구현하는 방식을 이용했으며, 단일 onclicklistener로 두개의 클릭 이벤트를 동시에 처리할 수 있었다. 
* ![KakaoTalk_20220705_213027621_04](https://user-images.githubusercontent.com/90722804/177329050-2ad0e8e0-893d-4720-8b4c-19a022e6b58c.jpg)

## 4. Tab4 : 배틀 앱
* 갤러리에 있는 포켓몬 캐릭터 이미지 20개 중 두 개를 선택하여 배틀 게임을 할 수 캐릭있는 탭이다.
* 포켓몬 게임에는 캐릭터별 사용 가능한 skill, 고유 hp가 존재한다.
* 스킬들에는 고유의 스킬 이미지, 공격 성공 확률과 파워가 존재한다.
* 두 포켓몬이 번갈아가며 상대방에게 공격을 하고, 항복하거나 hp를 먼저 소진한 포켓몬이 지는 게임이다.
* 캐릭터마다 싸우기를 선택할때 4개 이하의 스킬을 사용할 수 있으며, 스킬 고유의 공격 성공 확률에 따라 상대 포켓몬의 hp가 소진된다.
* - 현재 hp바가 연속적으로 반영되지 않는 문제를 해결 중에 있으며, starting page, pokemon pick page, battlefield에서의 공격 효과 구현, 공격 데미지 함수 구현, 그리고 한 쪽이 패배하거나 항복 시에 나오는 화면, 다시 main activity로 돌아가는 화면을 모두 구현 완료하였다.

![KakaoTalk_20220705_213027621_03](https://user-images.githubusercontent.com/90722804/177329276-29a5ff9d-6b06-4e41-becc-20287160686c.jpg)
![KakaoTalk_20220705_213027621_06](https://user-images.githubusercontent.com/90722804/177329296-4e38cd72-e785-421a-a607-e03f2210bba2.jpg)

![KakaoTalk_20220705_213027621_01](https://user-images.githubusercontent.com/90722804/177329311-c99975fe-6852-4871-9a14-028f66910d6d.jpg)

![KakaoTalk_20220705_213027621_02](https://user-images.githubusercontent.com/90722804/177329333-9b6073a8-0729-4475-bf14-6ffd8daf142f.jpg)

![KakaoTalk_20220705_213027621_05](https://user-images.githubusercontent.com/90722804/177329347-00eb07dd-5f3c-474f-b832-788d2c28ab4b.jpg)

![KakaoTalk_20220705_213027621](https://user-images.githubusercontent.com/90722804/177329528-48dbd1d7-3038-4aab-b361-11b647c89544.jpg)

