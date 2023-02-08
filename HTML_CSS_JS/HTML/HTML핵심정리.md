```html
<apex:page docType="html-5.0">
    <head>
        <style>
            span {
            	color : red
            }
            .blue {
            	color : blue
            }
            #abc {
            	color : green
            }
        </style>
    </head>
    <body>
        <div>
            <h1>
                오늘의 날씨
            </h1>
            <p>
                중부 집중호우, 남부는 열대야,12호 태풍 북상 중..
            </p>
            <img src = "sdasd.jpg"/>
            <ul>
                <li>사과</li>
                <li>딸기</li>
                <li>수박</li>
                <li>오렌지</li>
            </ul>
            <!-- target="_blank": 링크 이동시 새 탭에 브라우저 실행, title="네이버로 이동" : 커서 가져다대면 뜨는 문구 -->
            <a href="https://www.naver.com" target="_blank" title="네이버로 이동">NAVER</a>
            <span>동해물</span>과 백두산이
        </div>
        <input type="text" value="입력하십시오."/><br/>
        <input type="text" placeholder="이름을 입력하세요!"/><br/>
        <input type="text" disabled=" "/><br/>
        <label>
            <input type="checkbox"/> Apple
        </label>
        <br/>
        <label>
            <input type="checkbox" checked=" "/> Banana
        </label>        
        <br/>
        <br/>
        <lable>
            <input type="radio" name="fruits"/> Apple
        </lable>
        <lable>
            <input type="radio" name="fruits"/> Banana
        </lable>
        <br/>
        <br/>
        <table>
            <tr>
            	<td>a</td><td>b</td>
            </tr>
            <tr>
            	<td>c</td><td>d</td>
            </tr>
        </table>
        <br/>
        <br/>
        <!-- id : 고유해야됨(#), class는 중복가능(.)  -->
        <span>동해물</span>과 <span id="abc">백두산</span>이 마르고 닳도록 하느님이 보우하사 <span class="blue">우리나라</span>만세
        <br/>
        <br/>
        <div class ="a" data-fruit-name="apple">사과</div>
        <div class ="a" data-fruit-name="banana">바나나</div>
        
        <script>
                
        const els = document.querySelectorAll('div.a')
        els.forEach(el => {
        	console.log(el.dataset.fruitName)
        })
            
        </script>
    </body>    
</apex:page>
```
