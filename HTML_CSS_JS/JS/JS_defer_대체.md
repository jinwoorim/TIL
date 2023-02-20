```html
<apex:page >

      	<script>
        	window.addEventListener('load', function() {
            	let boxEl = document.querySelector('.box');
                
        		boxEl.addEventListener('click', function() {
                console.log("click!!");                                       
                });                 
            }) 
        </script>  
    
        <div class = "box">
            	Box!!
        </div>
</apex:page>

```
