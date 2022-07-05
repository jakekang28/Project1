# Android Studio Pokemon App
## App의 구조
* 세 개의 tab으로 구성하였고 각각 연락처, 갤러리, 게임배틀이다. 
##  1. Tab1 : 연락처 앱
* json file을 만들어 이름과 전화번호 정보를 넣어주고, RecyclerView에 정보들을 띄웠다. 
* Manifest.xml에서 해당 permission을 추가하니 recyclerview 클릭 후 바로 해당 번호의 전화 다이얼로 넘어갈 수 있었다.
```c
<uses-permission android:name="android.permission.DIAL_PHONE" />
```

## 2. Tab2 : 갤러리 앱
* 포켓몬 캐릭터 이미지 20개를 띄웠고, Recyclerview, StaggeredGridLayoutManager를 통해 3개의 이미지가 한 줄에 나오게 하였다.
* 하나의 이미지(view cell)을 클릭하면 해당 캐릭터 이미지를 크게 볼 수 있는 창이 나온다.
* 이 view의 재생 버튼을 클릭하면, 해당 캐릭터가 나오는 포켓몬 영상을 볼 수 있다.
* Intent와 startActivity를 통해 view끼리 이동할 수 있도록 했다.

## 3. Tab3 : 배틀 앱
* 갤러리에 있는 포켓몬 캐릭터 이미지 20개 중 두 개를 선택하여 배틀 게임을 할 수 있는 탭이다.
* 포켓몬 게임에는 캐릭터별 사용 가능한 skill, 고유 hp가 존재한다.
* 스킬들에는 고유의 스킬 이미지, 공격 성공 확률과 파워가 존재한다.
* 두 포켓몬이 번갈아가며 상대방에게 공격을 하고, 항복하거나 hp를 먼저 소진한 포켓몬이 지는 게임이다.
* 캐릭터마다 싸우기를 선택할때 4개 이하의 스킬을 사용할 수 있으며, 스킬 고유의 공격 성공 확률에 따라 상대 포켓몬의 hp가 소진된다.

