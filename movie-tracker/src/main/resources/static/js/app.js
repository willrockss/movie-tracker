  console.log("Going to update loading progress bar");
  const loadingProgressElement = document.getElementById("loading-progress");

  function updateLoading() {
    const progress = parseInt(loadingProgressElement.getAttribute("aria-valuenow"));
    const maxValue = parseInt(loadingProgressElement.getAttribute("aria-valuemax"));
    if (progress < maxValue) {
      const newProgress = Math.min(maxValue, progress + 5);
      loadingProgressElement.setAttribute("aria-valuenow", newProgress);
      loadingProgressElement.style.width = newProgress + "%";
      if (newProgress < maxValue) {
        setTimeout(updateLoading, 500);
      } else {
        document.getElementById("progress-bar-container").style.display = "none";
      }
    }
  }

  function showWelcomeBanner() {
    const banner = document.getElementById("empty-watchlist-banner")
    if (banner.classList.contains("d-none")) {
      banner.classList.toggle("d-none")
    }
  }

  function loadToWatchList() {
    return fetch("/watch-list-entry")
          .then(it => it.json());
  }

  async function showWatchList() {
    const tbody = document.getElementById("watch-list-table-body");
    while(tbody.firstChild) tbody.removeChild(tbody.lastChild);

    const resp = loadToWatchList();
    const rows = await resp
      .then(it => {
        console.log("Got page response: ", it);
        return it;
       })
      .then(it => it.content);

    rows.map(it => {
        const trTag = document.createElement("tr");

        const videoIdTag = document.createElement("td");
        videoIdTag.appendChild(document.createTextNode(it.videoId));
        trTag.appendChild(videoIdTag);

        const preCommentTag = document.createElement("td");
        preCommentTag.appendChild(document.createTextNode(it.preComment));
        trTag.appendChild(preCommentTag);

        return trTag;
    })
    .map(it => {
        tbody.appendChild(it);
    });

    // TODO Show banner only once and store state in the local storage
    if (rows.length == 0) {
      showWelcomeBanner();
    }
  }

  async function addToList() {
    const numberIF = document.getElementById("numberIF");
    const preCommentIF = document.getElementById("preCommentIF");
    console.log("Going to add " + numberIF.value + " - " + preCommentIF.value);

    const data = {
        videoId: numberIF.value,
        preComment: preCommentIF.value
    }

    try {
        const resp = await fetch("/watch-list-entry", {
            method: "POST",
            mode: "cors",
            credentials: "same-origin",
            headers: {
              "Content-Type": "application/json"
            },
            redirect: "follow",
            referrerPolicy: "no-referrer",
            body: JSON.stringify(data)
        }).then(it => it.json());

        if (resp.error) {
            alert(resp.message);
        } else {
            showWatchList();
            numberIF.value = "";
            preCommentIF.value = "";
        }
    } catch(err) {
        console.error(err.message, err);
        alert(err.message);
    }
  }

showWatchList();