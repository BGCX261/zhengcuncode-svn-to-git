function submitMe(func)
{
	var checked = 'N';
    var f = document.forms[0];

	for (i=0;i<f.elements.length;i++)
	{
        if(f.elements[i].name=="recordCheckBox")
		{
			if(f.elements[i].checked==true) checked='Y';
		}
	}

	if((func=='delete')
		&& checked=='N')
    {
        alert('请选择记录。');
		return;
    }

	if(func=='delete')
    {
        if(!confirm("确实要删除这些信息吗?")){ return; }
    }
    f.method.value=func;
    f.submit();
}


/**
列表中的检查框全部选择
**/
function checkAllBox()
{
    var f = document.forms[0];
    var checked = f.checkAll.checked;
    
	if(checked == false)
	{
		 for (i=0;i<f.elements.length;i++)
		{
			 if(f.elements[i].name=="recordCheckBox") 
				 f.elements[i].checked=false;
		}		 
         f.checkAll.checked=false;
	}
	else
	{
		for (i=0;i<f.elements.length;i++)
		{
			if(f.elements[i].name=="recordCheckBox") 
				f.elements[i].checked=true;
		}		 
		f.checkAll.checked=true;
	}
	
}

 //保留4位小数点
function getNumber (num)
{
  num = Math.round(num*10000);
  return num.toString().replace(/(\d{4})$/, ".$1");
}

function changePage(page)
{
	var f = document.forms[0];
	f.page.value = page;
	f.method.value="search";
    f.submit();
}