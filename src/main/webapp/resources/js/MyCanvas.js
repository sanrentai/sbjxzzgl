  var MyCanvas = function(boxObj, width, height) {
            //序号、计数
            var canvas = document.getElementById('jvchao');
            //2D画布对象
            this.ctx = canvas.getContext("2d");
            /* * 绘制线条
            * @ops JSON对象，可按实际支持属性扩展，示例：  { lineWidth:1,strokeStyle:'rgb(255,255,255)' }     
            * @dotXY:{ x:0, y:0 } ||[{ x:0, y:0 },{ x:0, y:0 }]
            */
            this.drawLine = function(dotXY, ops) {
                this.ctx.beginPath();
                for (var att in ops) this.ctx[att] = ops[att];
                dotXY = dotXY.constructor == Object ? [dotXY || { x: 0, y: 0}] : dotXY;
                this.ctx.moveTo(dotXY[0].x, dotXY[0].y);
                for (var i = 1, len = dotXY.length; i < len; i++) this.ctx.lineTo(dotXY[i].x, dotXY[i].y);
                this.ctx.stroke();
            };
        };