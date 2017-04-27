$(document).ready(function () {
    //ボタンEnterキーによる動作を止める
    $("form")
            .keypress(preventEnterSubmithandler)
            .keyup(preventEnterSubmithandler);

    //设置Pace的模式
    window.paceOptions = {
        ajax: {
            trackMethods: ['GET', 'POST']
        }
        , elements: {
            selectors: ['.menulink']
        },
        startOnPageLoad: false
    };

    ///防止F5刷新页面
//    window.onbeforeunload = function (t) {
//        return t;
//    };

});

//Backspaceにより前ページへ繊維することを防止
$(document).unbind('keydown').bind('keydown', function (event) {
    var doPrevent = false;
    if (event.keyCode === 8) {
        var d = event.srcElement || event.target;
        if ((d.tagName.toUpperCase() === 'INPUT' &&
                (
                        d.type.toUpperCase() === 'TEXT' ||
                        d.type.toUpperCase() === 'NUMBER' ||
                        d.type.toUpperCase() === 'TEL' ||
                        d.type.toUpperCase() === 'PASSWORD' ||
                        d.type.toUpperCase() === 'FILE' ||
                        d.type.toUpperCase() === 'EMAIL' ||
                        d.type.toUpperCase() === 'SEARCH' ||
                        d.type.toUpperCase() === 'DATE')
                ) ||
                d.tagName.toUpperCase() === 'TEXTAREA') {
            doPrevent = d.readOnly || d.disabled;
        } else {
            doPrevent = true;
        }
    }

    if (doPrevent) {
        event.preventDefault();
    }
});



var REF_WIN = {
    /**
     * ESC押下後、参照windowを閉じる
     */
    close: function () {
        return $("a.ui-dialog-titlebar-close[role='button']").click();
    }
};

var PAGE_COM = {
    /**
     *  実行確認ボタンを開く
     * @param {XMLHTTPRequest} xhr
     * @param {Object} status
     * @param {Object} args
     */
    showCommitConfirmDialog: function (xhr, status, args) {

        if (args.hasNotBussinessError) {
            PF("cfmDiaCommit").show();
        }
    },
    /**
     *  SpotLight実行
     * @param {XMLHTTPRequest} xhr
     * @param {Object} status
     * @param {Object} args
     */
    spotlightInvoke: function (xhr, status, args) {
        if (args.validationFailed) {
            PF('validspot').show();
        } else {
            PF('validspot').hide();
        }
    },
    buttonShortCutKeyInvoke: function (id) {
        if (!id) {
            return;
        }
        var jqID = PrimeFaces.escapeClientId(id);
        var $target = $(jqID);
        if ($target.size() === 0) {
            return;
        }
        var isdisabled = $target.prop("disabled");
        if (!isdisabled) {
            $target.click();
        }
    },
    downloadProgressBarShow: function () {
        PF('progressDialog').show();
    },
    downloadProgressBarHide: function () {
        PF('progressDialog').hide();
    },
    /**
     * 
     * @param {txtbox} obj
     * @returns {void}
     */
    bindMonthPicker: function (obj) {
        $(obj).monthpicker({
            pattern: 'yyyy/mm'
            , monthNames: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
        });
    },
    /**
     * 
     * @param {string} id コントロールID
     * @param {int} addV 追加月数
     * @returns {void}
     */
    monthPickerMonthAdd: function (id, addV) {

        var _this = this;

        if (!id) {
            return;
        }
        var jqID = PrimeFaces.escapeClientId(id);
        var $target = $(jqID);
        if ($target.size() === 0) {
            return;
        }
        var v = $target.val();
        if (v === "")
            return;
        var d = new Date(v + "/01");
        d.setMonth(d.getMonth() + addV);

        $target.val(_this.formatDate(d, 'yyyy/MM'));
    }
    /**
     * 日付フォーマット
     * @param {Date} date
     * @param {string} format
     * @returns {String}
     */
    , formatDate: function (date, format) {
        if (!format)
            format = 'yyyy/MM/dd hh:mm:ss.SSS';
        format = format.replace(/yyyy/g, date.getFullYear());
        format = format.replace(/MM/g, ('0' + (date.getMonth() + 1)).slice(-2));
        format = format.replace(/dd/g, ('0' + date.getDate()).slice(-2));
        format = format.replace(/hh/g, ('0' + date.getHours()).slice(-2));
        format = format.replace(/mm/g, ('0' + date.getMinutes()).slice(-2));
        format = format.replace(/ss/g, ('0' + date.getSeconds()).slice(-2));
        if (format.match(/S/g)) {
            var milliSeconds = ('00' + date.getMilliseconds()).slice(-3);
            var length = format.match(/S/g).length;
            for (var i = 0; i < length; i++)
                format = format.replace(/S/, milliSeconds.substring(i, i + 1));
        }
        return format;
    }
    , openGMap: function (xhr, status, args) {

        //座標取得した場合のみ地図を表示する
        if (args.hasGetCoodination) {
            PF("wvMapDialog").show();
        }
    }
    /**
     * 文字アニメーション
     * @param {type} elemId タグID
     * @param {type} opt オプション
     * @returns {undefined}
     */
    , showTextAnimation: function (elemId, opt) {
        opt = opt || {};
        var _opt = {
            maxFontSize: opt.maxFontSize || 35
            , initialDelay: opt.initialDelay || 100
            , effectIn: opt.effectIn || "bounceInDown"
            , effectOut: opt.effectOut || null
            , shuffleIn: opt.shuffleIn || false
        };

        $(elemId).fitText(1, {maxFontSize: _opt.maxFontSize})
                .textillate({
                    initialDelay: _opt.initialDelay, in: {
                        effect: _opt.effectIn
                        , shuffle: _opt.shuffleIn
                    }
                });

    }

    , playAlertAudio: function () {
        $("#audAlert")[0].play();
    }
};

var preventEnterSubmithandler = function (event) {
    if (event.keyCode === 13) {
        var el = event.target;
        if (/button/i.test(el.tagName)) {
            return false;
        }
        if (/textarea/i.test(el.tagName)) {
            return true;
        }
        if (/input/i.test(el.tagName) && /file/i.test(el.type)) {
            return false;
        }
        event.stopPropagation();
        return false;
    }
    return true;
};

var restartPace = function () {
    Pace.restart();
};



//日历——————————————————————————————————————————
$(function () {

    //绘制月历体——————————————————————————————————————————

    for (var i = 0; i < 35; i++) {
        $("<li><span></span></li>").appendTo(".month-body").addClass("month-cell");
    }

    var today = new Date();

    var FullYear = today.getFullYear(); //获取年份
    var m = today.getMonth();           //获取月号
    var month = today.getMonth() + 1;     //获取月份

    if (month < 10) {
        month = "0" + month;
    }
    var date = today.getDate();	      //获取日期
    var day = today.getDay();           //获取星期

    var monthsNum = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var isleapyear = FullYear % 4;        //判断闰年
    if (isleapyear === 0) {
        monthsNum[1] = 29;
    }

    if (day === 0) {
        day = 7;
    }
    var firstDay = day - (date % 7 - 1);       //!important 计算月初星期数

    if (firstDay === 7) {                     //如果月初为七，归零
        firstDay = 0;
    }
    if (firstDay < 0) {                       //如果月初为负，加七循环
        firstDay += 7;
    }

    var f = firstDay;
    for (var j = 1; j <= monthsNum[m]; j++) {
        $("li.month-cell span").eq(f).text(j).parent().addClass("pink");
        f++;
    }

    $("li.month-cell span").eq(firstDay - 1 + date).parent().addClass("red");

    $(".month-head span").text(FullYear + "年" + month + "月");

});

function showErrorMsg() {
    errorMsg = document.getElementById("frmMain:msgValidation").innerHTML;
    if (!errorMsg) {
        return;
    }
    PAGE_COM.buttonShortCutKeyInvoke('frmMain:btnValidationPanel');
    //PF('frmMain:ovPnlValidation').show('#{component.clientId}');
}

var origPostShow = PrimeFaces.widget.Dialog.prototype.postShow;

PrimeFaces.widget.Dialog.prototype.postShow = function () {
    this.initSize();
    origPostShow.apply( this );
};

PrimeFaces.widget.Dialog.prototype.fitViewport = function () {
    var winHeight = $( window ).height();
    var contentPadding = this.content.innerHeight() - this.content.height();

    this.content.css("max-height", (winHeight - this.titlebar.outerHeight() - contentPadding - this.footer.outerHeight()) + "px" );
    this.content.css("overflow", "auto");
};
