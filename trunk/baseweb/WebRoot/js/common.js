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
        alert('��ѡ���¼��');
		return;
    }

	if(func=='delete')
    {
        if(!confirm("ȷʵҪɾ����Щ��Ϣ��?")){ return; }
    }
    f.method.value=func;
    f.submit();
}


/**
�б��еļ���ȫ��ѡ��
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

 //����4λС����
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