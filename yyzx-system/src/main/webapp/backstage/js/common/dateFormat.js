Date.prototype.Format = function(formatStr)  
{  
	var month = this.getMonth()+1;
    var str = formatStr;   
    var Week = ['日','一','二','三','四','五','六'];  
  
    str=str.replace(/yyyy|YYYY/,this.getFullYear());   
    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   
  
    str=str.replace(/MM/,month>9?month.toString():'0' + month);   
    str=str.replace(/M/g,month);   
  
    str=str.replace(/w|W/g,Week[this.getDay()]);   
  
    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
    str=str.replace(/d|D/g,this.getDate());   
  
    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
    str=str.replace(/h|H/g,this.getHours());   
    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
    str=str.replace(/m/g,this.getMinutes());   
  
    str=str.replace(/ss/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
    //str=str.replace(/s/g,this.getSeconds());
    
    
    str=str.replace(/SSS/,this.getMilliseconds()>9?this.getMilliseconds().toString():'0' + this.getMilliseconds());   
    //str=str.replace(/S/g,this.getMilliseconds());   
  
    return str;   
}; 