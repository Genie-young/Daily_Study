C9에서 플라스크 사용해서 웹 만들기

1. C9 단축키

   ! tab 하면 기본 html 템플릿 생성하기 

   div.container +tab누르면class 가container인 div 태그가 만들어짐 

   

2. flask 기본 사용 방법 

   `from flask import Flask`

   `app = Flask(__name__)`

   `@app.route("/")`
   `def hello():`
       `return "Hello World!"`

   

   기본으로  @app.route("/페이지 이름")을 선언해주고

   주소를 ~~ /페이지 이름으로 들어가면 app.route의 밑에 있는 함수를 실행함. 

   

   #서버 실행 옵션 설정 

   C9에서 원격으로 사용하는 것은 127.0.0.0(local host)로는 접속하지 못하므로

   0.0.0.0으로 host를 설정해주고 port 는 8080으로 지정함.

   (C9이 지정해놓은 포트는 8080이므로 변경 X )

   py파일에 다음 내용 추가 

   if __name__ == '__main__':
       app.run(debug =True, host='0.0.0.0', port=8080) 

   #이게 아니면 bash창에서 FLASK_APP=app.py flask run --host=$IP --port=$PORT 입력 

    

3. 실행 코드

   @app.route("/ego/<string:name>")
   def ego(name):
       url="http://api.giphy.com/v1/gifs/search?api_key=QWzxYsDW4MozC9ue1GcKFQZCmA6JXrGG&q="
       fake=Faker("ko_KR")
       job=fake.job() 
       

   <app.py>

   ```python
   @app.route("/ego/<string:name>")
   def ego(name):
       url="http://api.giphy.com/v1/gifs/search?api_key=QWzxYsDW4MozC9ue1GcKFQZCmA6JXrGG&q="
       fake=Faker("ko_KR")
       job=fake.job() 
       
       #json데이터를 파이썬의 딕셔너리로 바꾸어서 가져옴 .json()역할
       res = requests.get(url+job).json()
       # res_col = res["data"] #딕셔너리 안의 data 열을 가져옴.
       # res_get_data =res_col[0] #해당 열의 0번째 데이터를 가져와
       # img_url = res_get_data["original"]["url"]
       img_url = res["data"][0]["images"]["original"]["url"]
       return render_template("ego.html",img_url=img_url,name =name, job=job)
       
   ```
   < ego.html>

   ``{% extends "base.html" %}`
   `{% block body_block %}`
   `<!--"https://picsum.photos/300/300/?random"-->`
       `<div class="card" style="width: 18rem;">`
     `<img src="{{img_url}}" class="card-img-top" alt="...">`

     <div class="card-body">
       <h5 class="card-title">{{name}}님의 전생의 직업은 {{job}} 입니다.</h5>
       <a href="#" class="btn btn-primary">Go somewhere</a>
     </div>
   `</div>`
   {% endblock %}





참고 사이트 

https://www.lipsum.com/ : 더미 텍스트 넣기 (Lorem Ipsum ) 한글 Ipsum도 있음. 

https://picsum.photos/ : 더미 이미지 넣기

https://developers.giphy.com/ : giphy api 인터넷 이미지를 검색해서 쓸수있도록 해줌

https://startbootstrap.com/themes/ : 부트스트랩 무료 템플릿

https://fontawesome.com/ : <i> 태그 이미지 

https://getmdl.io/ : google css 템플릿

http://www.jeykill.com/ : 템플릿