(function () { 
	var aNavLi = $(".nav li");
	var aContainerLi = $(".container li");

	for (var i=0; i<aNavLi.length; i++) {
		(function(i){
			aNavLi[i].onclick = function() {
				for (var j=0; j<aNavLi.length; j++) {
					if (j==i) {
						$(aContainerLi[j]).show();
					} else {
						$(aContainerLi[j]).hide();
					}
				}
			}
		})(i);
	}
})();